class MealTimeMapper {

    stringToNumber(aMealTimeName) {
        if (aMealTimeName === "BREAKFAST") {
            return 0;
        } else if (aMealTimeName === "LUNCH") {
            return 1;
        } else if (aMealTimeName === "DINNER") {
            return 2;
        } else if (aMealTimeName === "SNACK") {
            return 3;
        } else if (aMealTimeName === "SUPPER") {
            return 4;
        }
    }
}

export default MealTimeMapper;