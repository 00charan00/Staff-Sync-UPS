export class EventDto {
  eventName:String;
  eventVenue:String;
  eventDate:Date;
  eventDescription:String;


  constructor(eventName: String, eventVenue: String, eventDate: Date, eventDescription: String) {
    this.eventName = eventName;
    this.eventVenue = eventVenue;
    this.eventDate = eventDate;
    this.eventDescription = eventDescription;
  }

}
