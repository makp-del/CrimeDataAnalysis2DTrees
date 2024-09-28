//Author: Manjunath K P

package edu.cmu.ds;

import org.slf4j.Logger;

/**
 * Utility class to get logger instance for a class
 */
public class LoggerUtil {

    /**
     * Get logger instance for a class
     *
     * @param clazz Class for which logger instance is required
     * @return Logger instance
     */
    public static Logger getLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz);
    }
}
