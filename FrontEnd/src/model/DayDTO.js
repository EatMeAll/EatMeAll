import MealDTO from "./MealDTO";

class DayDTO {
    constructor(id, date, mealsList) {
        this.id = id;
        this.date = date;
        this.meals = mealsList;
    }
}

DayDTO.fromRawData = (rawDayDTO) => {

    let mealDTOList = []
    for (const meal of rawDayDTO.meals) {
        let mealDTO = MealDTO.fromRawData(meal);
        mealDTOList.push(mealDTO);
    }
    return new DayDTO(rawDayDTO.id, rawDayDTO.date, mealDTOList)
}

export default DayDTO;


