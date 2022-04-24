package gg.bayes.challenge.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Slf4j
@UtilityClass
public class TimestampUtils {

	public static Long tsToMillis(String timestamp) {
		return LocalTime.parse(timestamp).toNanoOfDay() / 1000;
	}
}
