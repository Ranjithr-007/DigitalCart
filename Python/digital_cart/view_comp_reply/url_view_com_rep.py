from django.conf.urls import url
from view_comp_reply import views

urlpatterns=[
    url('^$',views.v_reply,name="v_reply"),
    url(r'^reply/(?P<cid>\w+)', views.reply, name='reply'),
]

