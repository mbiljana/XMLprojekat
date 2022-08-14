
export interface FollowRequestsDTOInterface {
  followerId:string;
  toFollowId: string;

}
export class FollowRequestsDTO implements FollowRequestsDTOInterface {
  followerId:string;
  toFollowId: string;

  constructor(obj: FollowRequestsDTOInterface) {
    this.followerId = obj.followerId;
    this.toFollowId = obj.toFollowId;
  }
}
