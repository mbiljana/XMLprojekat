export interface ChatDTOInterface {
  sender:string;
  reciever:string;

}
export class ChatDTO implements ChatDTOInterface {
  sender:string;
  reciever:string;

  constructor(obj: ChatDTOInterface) {
    this.sender = obj.sender;
    this.reciever = obj.reciever;
  }
}
