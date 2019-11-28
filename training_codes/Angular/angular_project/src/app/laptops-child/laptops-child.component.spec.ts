import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaptopsChildComponent } from './laptops-child.component';

describe('LaptopsChildComponent', () => {
  let component: LaptopsChildComponent;
  let fixture: ComponentFixture<LaptopsChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaptopsChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaptopsChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
