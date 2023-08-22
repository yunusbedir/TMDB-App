package domain

import com.seiko.imageloader.ImageLoaderConfigBuilder
import com.seiko.imageloader.util.LogPriority
import com.seiko.imageloader.util.Logger


fun ImageLoaderConfigBuilder.commonConfig() {
    logger = object : Logger {
        override fun log(
            priority: LogPriority,
            tag: String,
            data: Any?,
            throwable: Throwable?,
            message: String,
        ) {
            val string = buildString {
                if (data != null) {
                    append("[image data] ")
                    append(data.toString().take(100))
                    append('\n')
                }
                append("[message] ")
                append(message)
            }
            println("$tag , ${
                throwable ?: string
            }")
        }

        override fun isLoggable(priority: LogPriority) = priority >= LogPriority.DEBUG
    }

}