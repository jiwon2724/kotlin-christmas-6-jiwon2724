package model.benefit

enum class EventDay(val day: IntArray) {
    WEEKDAY(
        intArrayOf(
            3, 4, 5, 6, 7,
            10, 11, 12, 13, 14,
            17, 18, 19, 20, 21,
            24, 25, 26, 27, 28,
            31
        )
    ),

    CHRISTMAS(
        intArrayOf(
            1, 2, 3, 4, 5,
            6, 7, 8, 9, 10,
            11, 12, 13, 14, 15,
            16, 17, 18, 19, 20,
            21, 22, 23, 24, 25
        )
    ),

    WEEKEND(intArrayOf(
            1, 2,
            8, 9,
            15, 16,
            22, 23,
            29, 30
        )
    ),

    SPECIAL(intArrayOf(3, 10, 17, 24, 25, 31))
}