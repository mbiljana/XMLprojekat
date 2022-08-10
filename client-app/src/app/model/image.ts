import { User } from './user';
import { Company } from './company';

export interface ImageInterface {
  id?:number;
  name: string;
  type:string;
}
export class Image implements ImageInterface {
  id?:number;
  name: string;
  type:string;

  constructor(obj: ImageInterface) {
      this.id=obj.id;
      this.name=obj.name;
      this.type=obj.type;
  }
}
