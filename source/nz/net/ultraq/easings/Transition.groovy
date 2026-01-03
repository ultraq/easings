/*
 * Copyright 2024, Emanuel Rabina (http://www.ultraq.net.nz/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.easings

import groovy.transform.CompileStatic
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future
import java.util.function.Consumer

/**
 * A transition is an implementation of an easing function over time.  Given a
 * duration of how long the transition should last, this class will repeatedly
 * call a callback with the result of the easing function over that period.  It
 * is most useful for animating objects.
 *
 * @author Emanuel Rabina
 */
@CompileStatic
class Transition {

	private final EasingFunction easingFunction
	private final int durationMs
	private final Consumer<Float> callback
	private final int resolutionMs

	/**
	 * Constructor, create a new transition with the given duration easing
	 * function, and optional resolution.
	 *
	 * @param easingFunction
	 *   Any easing function, nominally any of the methods in {@link EasingFunctions}.
	 * @param durationMs
	 *   How long the transition should last.
	 * @param resolutionMs
	 *   How frequently the callback should be called.  By default this will be
	 *   1 millisecond.
	 * @param callback
	 *   A function that will be called with the result of the easing function at
	 *   each step of the transition.
	 */
	Transition(EasingFunction easingFunction, int durationMs, int resolutionMs = 1, Consumer<Float> callback) {

		this.easingFunction = easingFunction
		this.durationMs = durationMs
		this.resolutionMs = resolutionMs
		this.callback = callback
	}

	/**
	 * Starts the transition.
	 *
	 * @return
	 *   A {@code Future} that will be completed when the transition is.  It can
	 *   also be cancelled via thread interruption (eg: {@code future.cancel(true)}).
	 */
	Future<Void> start() {

		var startTimeMs = System.currentTimeMillis()
		var endTimeMs = startTimeMs + durationMs
		var step = 0
		return CompletableFuture.runAsync { ->
			while (!Thread.interrupted()) {
				var currentTimeMs = System.currentTimeMillis()
				if (currentTimeMs > endTimeMs) {
					callback.accept(easingFunction.transform(1f))
					break
				}
				var elapsedTimeMs = currentTimeMs - startTimeMs
				if (elapsedTimeMs >= resolutionMs * step) {
					callback.accept(easingFunction.transform(elapsedTimeMs / durationMs as float))
					step++
				}
				Thread.yield()
			}
		}
	}
}
