import {User} from "./user";
import {Message} from "./message";

export interface MessageNotifInterface{
  id:number;
  user:User;
  Date:Date;
  message:Message;
}
export class MessageNotif implements MessageNotifInterface{
  id:number;
  user:User;
  Date:Date;
  message:Message;

  constructor(obj:MessageNotifInterface) {
    this.id = obj.id;
    this.user = obj.user;
    this.Date = obj.Date;
    this.message = obj.message;
  }
}
