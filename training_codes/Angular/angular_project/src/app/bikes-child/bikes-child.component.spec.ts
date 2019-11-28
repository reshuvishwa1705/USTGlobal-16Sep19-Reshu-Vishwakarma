import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BikesChildComponent } from './bikes-child.component';

describe('BikesChildComponent', () => {
  let component: BikesChildComponent;
  let fixture: ComponentFixture<BikesChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BikesChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BikesChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
