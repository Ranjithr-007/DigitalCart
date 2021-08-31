from django.conf.urls import url
from staff_reg import views

urlpatterns=[
    url('^$',views.staff,name="staff")
]