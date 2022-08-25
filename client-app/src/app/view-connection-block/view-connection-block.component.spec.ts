import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewConnectionBlockComponent } from './view-connection-block.component';

describe('ViewConnectionComponent', () => {
  let component: ViewConnectionBlockComponent;
  let fixture: ComponentFixture<ViewConnectionBlockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewConnectionBlockComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewConnectionBlockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
