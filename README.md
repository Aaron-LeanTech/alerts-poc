# alerts-poc
IU alerts PoC

PoC to test adding custom tags to default http metrics.

Using a custom tags contributor, but needed to use a ControllerAdvice because of this: https://github.com/spring-projects/spring-boot/issues/21357 . To solve it I used the proposed workaround in the issue.
