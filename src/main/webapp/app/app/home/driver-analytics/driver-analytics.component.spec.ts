import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverAnalyticsComponent } from './driver-analytics.component';

describe('DriverAnalyticsComponent', () => {
  let component: DriverAnalyticsComponent;
  let fixture: ComponentFixture<DriverAnalyticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverAnalyticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverAnalyticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
