from django.conf.urls import url
from view_feedback import views

urlpatterns=[
    url('^$',views.view_feed,name="view_feed")
]

