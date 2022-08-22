export interface IsFollowingDTOInterface {
  id1:number;
  id2: number;
}
export class IsFollowingDTO implements IsFollowingDTOInterface {
  id1:number;
  id2: number;

  constructor(obj: IsFollowingDTOInterface) {
    this.id1 = obj.id1;
    this.id2 = obj.id2;
  }
}
