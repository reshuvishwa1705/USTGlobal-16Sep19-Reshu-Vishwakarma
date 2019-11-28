import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildCountriesComponent } from './child-countries.component';

describe('ChildCountriesComponent', () => {
  let component: ChildCountriesComponent;
  let fixture: ComponentFixture<ChildCountriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildCountriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildCountriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
