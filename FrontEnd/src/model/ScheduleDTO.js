import DayDTO from './DayDTO';

class ScheduleDTO {
    constructor(dayList) {
        this.dayList = dayList
    }
}

ScheduleDTO.fromRawData = (rawDTO) => {
    let days = []
    for (const day of rawDTO) {
        let dayDTO = DayDTO.fromRawData(day);
        days.push(dayDTO)
    }

    return new ScheduleDTO(days)
}

export default ScheduleDTO;
