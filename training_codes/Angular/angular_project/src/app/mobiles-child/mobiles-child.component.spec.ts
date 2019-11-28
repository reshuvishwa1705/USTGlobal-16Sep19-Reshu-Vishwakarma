import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MobilesChildComponent } from './mobiles-child.component';

describe('MobilesChildComponent', () => {
  let component: MobilesChildComponent;
  let fixture: ComponentFixture<MobilesChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MobilesChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MobilesChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
