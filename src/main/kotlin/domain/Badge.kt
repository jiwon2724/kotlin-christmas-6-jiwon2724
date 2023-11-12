package domain

import model.BadgeType

class Badge(private val benefitAmount: Int) {
    fun eventBadge(): BadgeType {
        return when (benefitAmount) {
            in STAR_RANGE -> BadgeType.STAR
            in TREE_RANGE -> BadgeType.TREE
            in SANTA_RANGE -> BadgeType.SANTA
            else -> BadgeType.NOTHING
        }
    }

    companion object {
        private val STAR_RANGE = 5000..9999
        private val TREE_RANGE = 10000..19999
        private val SANTA_RANGE = 20000 ..Int.MAX_VALUE
    }
}

// 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격