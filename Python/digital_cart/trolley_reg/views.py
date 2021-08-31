from django.shortcuts import render
from django.http import HttpResponse
from trolley_reg.models import TrolleyRegistration
# Create your views here.
import trolley_reg


def trolley(request):
    if request.method == "POST":
        obj = TrolleyRegistration()
        obj.trolley_no = request.POST.get("num")
        obj.v_id = 1
        obj.save()

    return render(request,'trolley_reg/trolly_reg.html')


