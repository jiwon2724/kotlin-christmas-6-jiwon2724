package model.menu

enum class Menu(
    val menuName: String,
    val type: MenuType,
    val price: Int
) {
    MUSHROOM_SOUP(menuName = "양송이수프", type = MenuType.APPETIZER, price = 6000),
    TAPAS(menuName = "타파스", type = MenuType.APPETIZER, price = 5500),
    CAESAR_SALAD(menuName = "시저샐러드", type = MenuType.APPETIZER, price = 8000),

    T_BONE_STEAK(menuName = "티본스테이크", type = MenuType.MAIN, price = 55000),
    BARBECUE_RIB(menuName = "바비큐립", type = MenuType.MAIN, price = 54000),
    SEAFOOD_PASTA(menuName = "해산물파스타", type = MenuType.MAIN, price = 35000),
    CHRISTMAS_PASTA(menuName = "크리스마스파스타", type = MenuType.MAIN, price = 25000),

    CHOCO_CAKE(menuName = "초코케이크", type = MenuType.DESSERT, price = 15000),
    ICE_CREAM(menuName = "아이스크림", type = MenuType.DESSERT, price = 5000),

    ZERO_COLA(menuName = "제로콜라", type = MenuType.BEVERAGE, price = 3000),
    RED_WINE(menuName = "레드와인", type = MenuType.BEVERAGE, price = 60000),
    CHAMPAGNE(menuName = "샴페인", type = MenuType.BEVERAGE, price = 25000),

    NOTHING(menuName = "없음", type = MenuType.NOTHING, price = 0)
}
