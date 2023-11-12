package model

enum class Menu(
    val productName: String,
    val type: Type,
    var count: Int = 0,
    val price: Int
) {
    MUSHROOM_SOUP(productName = "양송이수프", type = Type.APPETIZER, price = 6000),
    TAPAS(productName = "타파스", type = Type.APPETIZER, price = 5500),
    CAESAR_SALAD(productName = "시저샐러드", type = Type.APPETIZER, price = 8000),

    T_BONE_STEAK(productName = "티본스테이크", type = Type.MAIN, price = 55000),
    BARBECUE_RIB(productName = "바비큐립", type = Type.MAIN, price = 54000),
    SEAFOOD_PASTA(productName = "해산물파스타", type = Type.MAIN, price = 35000),
    CHRISTMAS_PASTA(productName = "크리스마스파스타", type = Type.MAIN, price = 25000),

    CHOCO_CAKE(productName = "초코케이크", type = Type.DESSERT, price = 15000),
    ICE_CREAM(productName = "아이스크림", type = Type.DESSERT, price = 5000),

    ZERO_COLA(productName = "제로콜라", type = Type.BEVERAGE, price = 3000),
    RED_WINE(productName = "레드와인", type = Type.BEVERAGE, price = 60000),
    CHAMPAGNE(productName = "샴페인", type = Type.BEVERAGE, price = 25000);
}

enum class Type {
    APPETIZER, DESSERT, MAIN, BEVERAGE
}

data class MenuDetail(
    val menu: Menu,
    val count: Int
)
