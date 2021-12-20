package com.example.logger.config

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

@Aspect
class LogTraceAspect(private val logTrace: LogTrace) {

    @Around("execution(* com.example.logger.app..*(..))")
    @Throws(Throwable::class)
    fun execute(joinPoint: ProceedingJoinPoint): Any {
        var status: TraceStatus? = null
        return try {
            val message = joinPoint.signature.toShortString()
            status = logTrace.begin(message)

            val result = joinPoint.proceed()
            logTrace.end(status)
            result
        } catch (e: Exception) {
            logTrace.exception(status!!, e)
            throw e
        }
    }
}
