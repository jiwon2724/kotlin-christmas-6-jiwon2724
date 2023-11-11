package model

enum class Menu(
    val productName: String,
    val type: String,
    var count: Int = 0,
    val price: Int
) {
    MUSHROOM_SOUP(productName = "양송이수프", type = "에피타이저", price = 6000),
    TAPAS(productName = "타파스", type = "에피타이저", price = 5500),
    CAESAR_SALAD(productName = "시저샐러드", type = "에피타이저", price = 8000),

    T_BONE_STEAK(productName = "티본스테이크", type = "메인", price = 55000),
    BARBECUE_RIB(productName = "바비큐립", type = "메인", price = 54000),
    SEAFOOD_PASTA(productName = "해산물파스타", type = "메인", price = 35000),
    CHRISTMAS_PASTA(productName = "크리스마스파스타", type = "메인", price = 25000),

    CHOCO_CAKE(productName = "초코케이크", type = "디저트", price = 15000),
    ICE_CREAM(productName = "아이스크림", type = "디저트", price = 5000),

    ZERO_COLA(productName = "제로콜라", type = "음료", price = 3000),
    RED_WINE(productName = "레드와인", type = "음료", price = 60000),
    CHAMPAGNE(productName = "샴페인", type = "음료", price = 25000);
}
