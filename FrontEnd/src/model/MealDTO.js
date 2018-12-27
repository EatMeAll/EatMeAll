
class MealDTO {

    constructor(id, language, mealTime, isPublic, shortDescription, title) {
        this.idMeal = id
        this.language = language
        this.mealTime = mealTime
        this.public = isPublic
        this.shortDescription = shortDescription
        this.title = title
    }

}


// Static method
MealDTO.fromRawData = (rewMealData) => {
    return new MealDTO(rewMealData.idMeal, rewMealData.language, rewMealData.mealTime, rewMealData.public, rewMealData.shortDescription, rewMealData.title)
}

export default MealDTO