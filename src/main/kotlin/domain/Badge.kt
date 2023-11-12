package domain

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

enum class BadgeType(val type: String) {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NOTHING("없음");
}