import { User } from './user';
import { Company } from './company';

export interface LanguageInterface {
  id?:number;
  name: string;
}
export class Language implements LanguageInterface {
  id?:number;
  name: string;

  constructor(obj: LanguageInterface) {
      this.id=obj.id;
      this.name=obj.name;
  }
}
