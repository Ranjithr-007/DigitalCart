from django.conf.urls import url
from trolley_reg import views

urlpatterns=[
    url('^$',views.trolley,name="trolley")
]