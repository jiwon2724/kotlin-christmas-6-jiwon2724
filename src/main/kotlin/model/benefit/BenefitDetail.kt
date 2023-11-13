package model.benefit

data class BenefitDetail(
    val type: BenefitType,
    val disCount: Int = 0
)