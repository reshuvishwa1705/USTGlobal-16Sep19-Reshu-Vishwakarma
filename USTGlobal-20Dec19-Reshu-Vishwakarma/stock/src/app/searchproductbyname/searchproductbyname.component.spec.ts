import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchproductbynameComponent } from './searchproductbyname.component';

describe('SearchproductbynameComponent', () => {
  let component: SearchproductbynameComponent;
  let fixture: ComponentFixture<SearchproductbynameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchproductbynameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchproductbynameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
