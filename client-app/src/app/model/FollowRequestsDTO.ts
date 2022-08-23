export interface FollowRequestsDTOInterface {
  followerId:String;
  toFollowId: String;
}
export class FollowRequestsDTO implements FollowRequestsDTOInterface {
  followerId:String;
  toFollowId: String;

  constructor(obj: FollowRequestsDTOInterface) {
    this.followerId = obj.followerId;
    this.toFollowId = obj.toFollowId;
  }
}
