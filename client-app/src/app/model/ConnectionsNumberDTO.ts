export interface ConnectionsNumberDTOInterface {
  connectionsNum:bigint;

}
export class ConnectionsNumberDTO implements ConnectionsNumberDTOInterface {
  connectionsNum:bigint;

  constructor(obj: ConnectionsNumberDTOInterface) {
    this.connectionsNum = obj.connectionsNum;
  }
}
