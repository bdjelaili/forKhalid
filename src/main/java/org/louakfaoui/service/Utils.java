package org.louakfaoui.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
	public static Long extractId(String url) {
		url = url.substring(0, url.length() - 1);
		return Long.valueOf(url.substring(url.lastIndexOf('/') + 1));
	}
}
