/**
 * 
 */
package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swathi cheela
 *
 */
@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "das boot, reporting for duty!";
	}
}
