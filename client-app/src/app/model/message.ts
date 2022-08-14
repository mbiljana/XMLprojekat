export interface MessageInterface{
  id?:number;
  senderUsername:string;
  recieverUsername:string;
  message:string;
}
export class Message implements MessageInterface{
  id?:number;
  senderUsername:string;
  recieverUsername:string;
  message:string;

  constructor(obj:MessageInterface) {
    this.id = obj.id;
    this.senderUsername = obj.senderUsername;
    this.recieverUsername = obj.recieverUsername;
    this.message = obj.message;
  }
}
