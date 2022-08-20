import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewChatOnelineComponent } from './view-chat-oneline.component';

describe('ViewChatOnelineComponent', () => {
  let component: ViewChatOnelineComponent;
  let fixture: ComponentFixture<ViewChatOnelineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewChatOnelineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewChatOnelineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
