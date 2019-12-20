import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchproductbycompanyComponent } from './searchproductbycompany.component';

describe('SearchproductbycompanyComponent', () => {
  let component: SearchproductbycompanyComponent;
  let fixture: ComponentFixture<SearchproductbycompanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchproductbycompanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchproductbycompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
