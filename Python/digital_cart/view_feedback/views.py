from django.shortcuts import render
from django.http import HttpResponse
from view_feedback.models import Feedback


# Create your views here.

def view_feed(request):
    objlist=Feedback.objects.all()

    context={
        'objval': objlist,
    }

    return render(request, 'view_feedback/view_feed.html', context)

