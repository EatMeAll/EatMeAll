class MealInfoData {

    constructor(aId, aName, aMealTime) {
        this.id = aId;
        this.name = aName;
        this.mealTime = aMealTime;
    }

    getId() {
        return this.id;
    }

    getMealName() {
        return this.name;
    }

    getMealTime() {
        return this.mealTime;
    }
}

export default MealInfoData