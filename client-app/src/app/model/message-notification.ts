import {User} from "./user";
import {Message} from "./message";

export interface MessageNotifInterface{
  id:number;
  Date:Date;
  message: Message;
  user:string;
}
export class MessageNotif implements MessageNotifInterface{
  id:number;
  Date:Date;
  message:Message;
  user:string;

  constructor(obj:MessageNotifInterface) {
    this.id = obj.id;
    this.Date = obj.Date;
    this.message = obj.message;
    this.user = obj.user;
  }
}
