import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchproductbycategoryComponent } from './searchproductbycategory.component';

describe('SearchproductbycategoryComponent', () => {
  let component: SearchproductbycategoryComponent;
  let fixture: ComponentFixture<SearchproductbycategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchproductbycategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchproductbycategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
