from django.conf.urls import url
from view_prod import views

urlpatterns=[
    url('^$',views.prod,name="prod")
]