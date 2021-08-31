from django.shortcuts import render
from django.http import HttpResponse
from staff_reg.models import Staff
# Create your views here.
import staff_reg

def staff(request):
    if request.method=="POST":
        obj=Staff()
        obj.name = request.POST.get("un")
        obj.address = request.POST.get("add")
        obj.gender = request.POST.get("Gender")
        obj.phone = request.POST.get("ph")
        obj.mail = request.POST.get("Email")
        obj.password = request.POST.get("pass")
        obj.v_id = 1
        obj.save()
    return render(request,'staff_reg\staff_reg.html')