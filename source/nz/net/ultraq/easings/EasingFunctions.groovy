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

/**
 * A collection of easing functions, adapted from the
 * <a href="https://easings.net/">Easing functions cheat sheet</a>.
 *
 * @author Emanuel Rabina
 */
@CompileStatic
class EasingFunctions {

	/**
	 * Convenience method for a linear interpolation.
	 */
	static float linear(float x) {
		return x
	}

	/**
	 * <a href="https://easings.net/#easeInSine">https://easings.net/#easeInSine</a>
	 */
	static float easeInSine(float x) {
		return 1 - Math.cos((x * Math.PI) / 2)
	}

	/**
	 * <a href="https://easings.net/#easeOutSine">https://easings.net/#easeOutSine</a>
	 */
	static float easeOutSine(float x) {
		return Math.sin((x * Math.PI) / 2)
	}

	/**
	 * <a href="https://easings.net/#easeInOutSine">https://easings.net/#easeInOutSine</a>
	 */
	static float easeInOutSine(float x) {
		return -(Math.cos(Math.PI * x) - 1) / 2
	}

	/**
	 * <a href="https://easings.net/#easeInQuad">https://easings.net/#easeInQuad</a>
	 */
	static float easeInQuad(float x) {
		return x**2
	}

	/**
	 * <a href="https://easings.net/#easeOutQuad">https://easings.net/#easeOutQuad</a>
	 */
	static float easeOutQuad(float x) {
		return 1 - (1 - x)**2
	}

	/**
	 * <a href="https://easings.net/#easeInOutQuad">https://easings.net/#easeInOutQuad</a>
	 */
	static float easeInOutQuad(float x) {
		return x < 0.5 ? 2 * x**2 : 1 - (-2 * x + 2)**2 / 2
	}

	/**
	 * <a href="https://easings.net/#easeInCubic">https://easings.net/#easeInCubic</a>
	 */
	static float easeInCubic(float x) {
		return x**3
	}

	/**
	 * <a href="https://easings.net/#easeOutCubic">https://easings.net/#easeOutCubic</a>
	 */
	static float easeOutCubic(float x) {
		return 1 - (1 - x)**3
	}

	/**
	 * <a href="https://easings.net/#easeInOutCubic">https://easings.net/#easeInOutCubic</a>
	 */
	static float easeInOutCubic(float x) {
		return x < 0.5 ? 4 * x**3 : 1 - (-2 * x + 2)**3 / 2
	}

	/**
	 * <a href="https://easings.net/#easeInQuart">https://easings.net/#easeInQuart</a>
	 */
	static float easeInQuart(float x) {
		return x**4
	}

	/**
	 * <a href="https://easings.net/#easeOutQuart">https://easings.net/#easeOutQuart</a>
	 */
	static float easeOutQuart(float x) {
		return 1 - (1 - x)**4
	}

	/**
	 * <a href="https://easings.net/#easeInOutQuart">https://easings.net/#easeInOutQuart</a>
	 */
	static float easeInOutQuart(float x) {
		return x < 0.5 ? 8 * x**4 : 1 - (-2 * x + 2)**4 / 2
	}

	/**
	 * <a href="https://easings.net/#easeInQuint">https://easings.net/#easeInQuint</a>
	 */
	static float easeInQuint(float x) {
		return x**5
	}

	/**
	 * <a href="https://easings.net/#easeOutQuint">https://easings.net/#easeOutQuint</a>
	 */
	static float easeOutQuint(float x) {
		return 1 - (1 - x)**5
	}

	/**
	 * <a href="https://easings.net/#easeInOutQuint">https://easings.net/#easeInOutQuint</a>
	 */
	static float easeInOutQuint(float x) {
		return x < 0.5 ? 16 * x**5 : 1 - (-2 * x + 2)**5 / 2
	}

	/**
	 * <a href="https://easings.net/#easeInExpo">https://easings.net/#easeInExpo</a>
	 */
	static float easeInExpo(float x) {
		return x == 0 ? 0 : 2**(10 * x - 10)
	}

	/**
	 * <a href="https://easings.net/#easeOutExpo">https://easings.net/#easeOutExpo</a>
	 */
	static float easeOutExpo(float x) {
		return x == 1 ? 1 : 1 - 2**(-10 * x)
	}

	/**
	 * <a href="https://easings.net/#easeInOutExpo">https://easings.net/#easeInOutExpo</a>
	 */
	static float easeInOutExpo(float x) {
		return x == 0 ? 0 : x == 1 ? 1 : x < 0.5 ? 2**(20 * x - 10) / 2 : (2 - 2**(-20 * x + 10)) / 2
	}

	/**
	 * <a href="https://easings.net/#easeInCirc">https://easings.net/#easeInCirc</a>
	 */
	static float easeInCirc(float x) {
		return 1 - Math.sqrt(1 - x**2)
	}

	/**
	 * <a href="https://easings.net/#easeOutCirc">https://easings.net/#easeOutCirc</a>
	 */
	static float easeOutCirc(float x) {
		return Math.sqrt(1 - (1 - x)**2)
	}

	/**
	 * <a href="https://easings.net/#easeInOutCirc">https://easings.net/#easeInOutCirc</a>
	 */
	static float easeInOutCirc(float x) {
		return x < 0.5 ? (1 - Math.sqrt(1 - 2 * x**2)) / 2 : (Math.sqrt(1 - (-2 * x + 2)**2) + 1) / 2
	}

	/**
	 * <a href="https://easings.net/#easeInBack">https://easings.net/#easeInBack</a>
	 */
	static float easeInBack(float x) {
		var c1 = 1.70158
		var c3 = c1 + 1
		return c3 * x**3 - c1 * x**2
	}

	/**
	 * <a href="https://easings.net/#easeOutBack">https://easings.net/#easeOutBack</a>
	 */
	static float easeOutBack(float x) {
		var c1 = 1.70158
		var c3 = c1 + 1
		return 1 + c3 * (x - 1)**3 + c1 * (x - 1)**2
	}

	/**
	 * <a href="https://easings.net/#easeInOutBack">https://easings.net/#easeInOutBack</a>
	 */
	static float easeInOutBack(float x) {
		var c1 = 1.70158
		var c2 = c1 * 1.525
		return x < 0.5
			? ((2 * x)**2 * ((c2 + 1) * 2 * x - c2)) / 2
			: ((2 * x - 2)**2 * ((c2 + 1) * (x * 2 - 2) + c2) + 2) / 2
	}

	/**
	 * <a href="https://easings.net/#easeInElastic">https://easings.net/#easeInElastic</a>
	 */
	static float easeInElastic(float x) {
		var c4 = (2 * Math.PI) / 3
		return x == 0 ? 0 : x == 1 ? 1 : -Math.pow(2, 10 * x - 10) * Math.sin((x * 10 - 10.75) * c4)
	}

	/**
	 * <a href="https://easings.net/#easeOutElastic">https://easings.net/#easeOutElastic</a>
	 */
	static float easeOutElastic(float x) {
		var c4 = (2 * Math.PI) / 3
		return x == 0 ? 0 : x == 1 ? 1 : Math.pow(2, -10 * x) * Math.sin((x * 10 - 0.75) * c4) + 1
	}

	/**
	 * <a href="https://easings.net/#easeInOutElastic">https://easings.net/#easeInOutElastic</a>
	 */
	static float easeInOutElastic(float x) {
		var c5 = (2 * Math.PI) / 4.5
		return x == 0 ? 0 : x == 1 ? 1 : x < 0.5
			? -(Math.pow(2, 20 * x - 10) * Math.sin((20 * x - 11.125) * c5)) / 2
			: (Math.pow(2, -20 * x + 10) * Math.sin((20 * x - 11.125) * c5)) / 2 + 1
	}

	/**
	 * <a href="https://easings.net/#easeInBounce">https://easings.net/#easeInBounce</a>
	 */
	static float easeInBounce(float x) {
		return 1 - easeOutBounce(1 - x as float)
	}

	/**
	 * <a href="https://easings.net/#easeOutBounce">https://easings.net/#easeOutBounce</a>
	 */
	static float easeOutBounce(float x) {
		var n1 = 7.5625
		var d1 = 2.75
		if (x < 1 / d1) {
			return n1 * x * x
		}
		else if (x < 2 / d1) {
			return n1 * (x -= 1.5 / d1) * x + 0.75
		}
		else if (x < 2.5 / d1) {
			return n1 * (x -= 2.25 / d1) * x + 0.9375
		}
		else {
			return n1 * (x -= 2.625 / d1) * x + 0.984375
		}
	}

	/**
	 * <a href="https://easings.net/#easeInOutBounce">https://easings.net/#easeInOutBounce</a>
	 */
	static float easeInOutBounce(float x) {
		return x < 0.5 ? easeInBounce(x * 2 as float) / 2 : easeOutBounce(x * 2 - 1 as float) / 2 + 0.5
	}
}
