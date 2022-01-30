package az.developia.course.qrup28.enums;

public enum ExceptionCode {
    STUDENT_NOT_FOUND_EXCEPTION(100),
    VALIDATION_EXCEPTION(101),
    STUDENT_CLASS_NOT_FOUND(102),
    TEACHER_CLASS_NOT_FOUND(103);

    private final int code;

    ExceptionCode(int i) {
        code = i;
    }

    public int getCode() {
        return code;
    }
}
