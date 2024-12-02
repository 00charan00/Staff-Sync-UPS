import {Component, OnInit} from '@angular/core';
import {EventsService} from '../service/events.service';
import {Events} from '../model/event';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {EventDto} from '../model/event-dto';


@Component({
  selector: 'app-events',
  imports: [
    ReactiveFormsModule,
    FormsModule,
    DatePipe

  ],
  templateUrl: './events.component.html',
  styleUrl: './events.component.css'
})
export class EventsComponent implements OnInit{

  events?:Events[];
  eventForm = new FormGroup({
    eventName: new FormControl(''),
    eventLocation: new FormControl(''),
    eventDate: new FormControl(new Date()),
    eventDescription: new FormControl(''),
  })

  constructor(private eventService:EventsService, private datePipe:DatePipe) {
  }

  ngOnInit(): void {
    this.eventService.getEvents().subscribe(
      events => {
        this.events = events;
      }
    )
  }

  postEvent(){
    let name = this.eventForm.controls.eventName.value
    let location = this.eventForm.controls.eventLocation.value
    let date = this.eventForm.controls.eventDate.value
    let desc = this.eventForm.controls.eventDescription.value
    console.log(date);
    if(name != null && name != '' &&
      location != null && location != '' &&
      date != null && desc != null && desc != ''){
      let formattedDate = this.datePipe.transform(date,"dd-MM-yyyy HH:mm a");
      console.log("Formatted Date:", formattedDate);

      if(formattedDate!= null)date = new Date(formattedDate);
        let event = new EventDto(name,location,date,desc);
        this.eventService.postEvent(event).subscribe(
          res => {
            console.log(res);

          }
        )

    }else{
      console.log("fill all details");
    }
  }

}
