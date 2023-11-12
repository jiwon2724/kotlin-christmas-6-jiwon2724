package model

enum class BenefitType(val type: String) {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    SPECIAL("특별 할인"),
    PRESENT_EVENT("증정 이벤트");
}