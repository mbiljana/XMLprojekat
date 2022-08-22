import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchJobViewComponent } from './search-job-view.component';

describe('SearchJobViewComponent', () => {
  let component: SearchJobViewComponent;
  let fixture: ComponentFixture<SearchJobViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchJobViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchJobViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
